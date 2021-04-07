select user(),database();

grant all 
    on web_gradle_erp.*
    to 'user_gradle_erp'@'localhost'
identified by 'rootroot';

-- file 권한(backup, load) -- root만 권한 부여 가능
GRANT File 
   ON *.* 
   TO 'user_gradle_erp'@'localhost';