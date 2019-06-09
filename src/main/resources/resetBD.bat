@Echo Off
cd C:\Program Files\MySQL\MySQL Workbench 8.0 CE
mysql.exe --protocol=tcp --host=localhost --user=root --password=root --port=3306 --database=bugtracker  < "C:\\mantis\\mantis_base.sql"

exit