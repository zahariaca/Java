GRANT SELECT ON *.* TO `mysql.infoschema`@`localhost`
GRANT SUPER ON *.* TO `mysql.session`@`localhost`
GRANT PERSIST_RO_VARIABLES_ADMIN,SYSTEM_VARIABLES_ADMIN ON *.* TO `mysql.session`@`localhost`
GRANT SELECT ON `performance_schema`.* TO `mysql.session`@`localhost`
GRANT SELECT ON `mysql`.`user` TO `mysql.session`@`localhost`
GRANT USAGE ON *.* TO `mysql.sys`@`localhost`
GRANT TRIGGER ON `sys`.* TO `mysql.sys`@`localhost`
GRANT SELECT ON `sys`.`sys_config` TO `mysql.sys`@`localhost`
GRANT USAGE ON *.* TO `test`@`localhost`
GRANT ALL PRIVILEGES ON `test`.* TO `test`@`localhost`
