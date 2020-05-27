-- https://github.com/mybatis/migrations/issues/49
-- @DELIMITER /

-- https://stackoverflow.com/questions/30710990/creating-an-oracle-user-if-it-doesnt-already-exist
declare
userexist integer;
begin
  select count(*) into userexist from dba_users where username='SCOTT';
  if (userexist = 1) then
    execute immediate 'DROP USER scott CASCADE';
  end if;
end;
/

-- @DELIMITER ;

CREATE USER scott IDENTIFIED BY tiger;

GRANT CONNECT, RESOURCE TO scott;
