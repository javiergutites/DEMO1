-- SPRINGMVC_BASE
INSERT INTO profiles (NAME) VALUES ('Superadministrador');
INSERT INTO profiles (NAME) VALUES ('Administrador');

INSERT INTO roles (NAME) VALUES ('ROLE_ADMIN_CATALOGO');
INSERT INTO roles (NAME) VALUES ('ROLE_PUBLIC_CATALOGO');

INSERT INTO profiles_roles (PROFILES, ROLES) VALUES ('Superadministrador', 'ROLE_ADMIN_CATALOGO');
INSERT INTO profiles_roles (PROFILES, ROLES) VALUES ('Superadministrador', 'ROLE_PUBLIC_CATALOGO');
INSERT INTO profiles_roles (PROFILES, ROLES) VALUES ('Administrador', 'ROLE_PUBLIC_CATALOGO');

INSERT INTO companies (ID, NAME) VALUES (1, 'Vector Software SL');

INSERT INTO users (ID, NAME, SURNAME, USERNAME, PASSWORD, ACTIVE, PROFILE, COMMENTS, COMPANY, EMAIL) VALUES (1, 'Marce', 'Rodriguez', 'ADMIN', 'VECTORSF', true, 'Superadministrador', '', 1, 'mrodriguezy@vectorsf.com');
INSERT INTO users (ID, NAME, SURNAME, USERNAME, PASSWORD, ACTIVE, PROFILE, COMMENTS, COMPANY, EMAIL) VALUES (2, 'Marce', 'Rodriguez', 'ADMIN2', 'VECTORSF', true, 'Administrador', '', 1, 'mrodriguezy@vectorsf.com');

-- TEST_BASE
INSERT INTO test_base (FIELD1, FIELD2) VALUES (1, 'Test 1');
INSERT INTO test_base (FIELD1, FIELD2) VALUES (2, 'Test 2');