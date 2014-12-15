/*
 * NAME = com.vectorsf.springmvc_base.utils.file.email.EmailManager.java;
 *
 * COPYRIGHT (c) 2011 Vector Software Factory S.L. Reservados todos los derechos.
 * Este programa es material confidencial propiedad
 * de Vector Software Factory S.L. Se prohíbe la divulgación o revelación
 * de su contenido sin el permiso previo y por escrito del propietario.
 * COPYRIGHT (c) 2011 Vector Software Factory S.L. All rights reserved.
 * This document (Program, manual, etc.) consists of confidential information,
 * containing trade secrets that are property of Vector Software Factory S.L.
 * Its content may not be used or disclosed without prior written permission
 * of the owner.
 */

package com.vectorsf.test_base.utils.email;

import java.util.HashMap;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * Class description: Manager para la gestión de envío de mails.
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

@Service
public class EmailManager {
	
	private static final Logger log = LoggerFactory.getLogger(EmailManager.class);
	@Autowired
    private VelocityEngine velocityEngine;
	@Autowired
    private JavaMailSender mailSender;
	
    /**
     * Sends e-mail using Velocity template for the body and 
     * the properties passed in as Velocity variables.
     * 
     * @param   msg                 The e-mail message to be sent, except for the body.
     * @param   hTemplateVariables  Variables to use when processing the template. 
     */
    public void send(final EmailData emailData) {
    	log.info("EMAIL - Preparing send mail: " + emailData.toString());
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
               message.setTo(emailData.getTo());
               message.setFrom(emailData.getFrom());
               message.setSubject(emailData.getSubject());
               message.setCc(emailData.getCc());
               message.setBcc(emailData.getBcc());
               velocityEngine.setProperty("ouput.encoding", "UTF-8");
               velocityEngine.setProperty("input.encoding", "UTF-8");
               velocityEngine.setProperty("default.contentType", "text/html; charset=utf-8");

               String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, emailData.getTemplate(), emailData.getAttributes());
               
               log.debug("body = " + body);

               message.setText(body, true);
            }
         };
         
         mailSender.send(preparator);
        
        log.info("EMAIL - Sent e-mail " + emailData.toString());
    }
    
    /**
     * Envía un correo.
     * @param subject asunto
     * @param template plantilla del correo
     * @param from remitente
     * @param to destinatario/s
     * @param cc carbon copy
     * @param bcc black carbon copy
     * @param attributes atributos de la plantilla
     */
    public void send(String subject, String template, String from, String[] to, String[] cc, String[] bcc, HashMap<String, Object> attributes) {
    	EmailData emailData = new EmailData();
		emailData.setFrom(from);
		emailData.setSubject(subject);
		emailData.setTemplate(template);
		emailData.setTo(to);
		emailData.setCc(cc);
		emailData.setBcc(bcc);
		emailData.setAttributes(attributes);
		send(emailData);
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
     }

     public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
     }
}
