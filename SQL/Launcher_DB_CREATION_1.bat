rem SQL Script Launcher
rem
rem Jaycee
rem

echo "Launcher..."
echo "SQL Script: DB_CREATION_1.sql"
echo ""

rem Help from https://docs.microsoft.com/fr-fr/sql/relational-databases/scripting/sqlcmd-use-the-utility?view=sql-server-2017
rem

rem Connecting to a default instance by using Windows Authentication to interactively run Transact-SQL statements:
rem sqlcmd -S <ComputerName>  

rem Connecting to a named instance by using Windows Authentication and specifying input and output files:
rem sqlcmd -S <ComputerName>\<InstanceName> -i <MyScript.sql> -o <MyOutput.rpt>

rem Connecting to the default instance on the local computer by using Windows Authentication, executing a query, and having sqlcmd remain running after the query has finished running:
rem sqlcmd -q "SELECT * FROM AdventureWorks2012.Person.Person"

rem Connecting to a named instance using SQL Server Authentication to interactively run Transact-SQL statements, with sqlcmd prompting for a password:
rem sqlcmd -U MyLogin -S <ComputerName>\<InstanceName>
rem

rem sqlcmd -S .\MSSQLSERVER -i DB_CREATION_1.sql -o DB_CREATION_1.rpt		AUTHENTIF NE FONCTIONNE PAS

sqlcmd -i DB_CREATION_1.sql -o DB_CREATION_1.rpt


pause


