### Dokumentacja API
http://localhost:8080/swagger-ui.html

### Jak uruchomić aplikacje?
Projekt został stworzony dla środowiska IntelliJ IDEA.
Wymagana jest baza danych SQLServer. Uruchamiamy ją za pomocą Dockera.
1. Za pierwszym razem: `docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=Kinomaniak@321" -p 1433:1433 --name "IODatabase" -d mcr.microsoft.com/mssql/server:latest`
3. `docker exec -it IODatabase /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P "Kinomaniak@321" -Q "create database kinodb"`
2. Za każdym kolejnym po restarcie kompa/wyłączeniu dockera: `docker start IODatabase`
3. Ustawienia bazy znajdują się w pliku `src/main/resources/application.properties`

- Jak ktoś nie chce używać Dockera, to niech sobie zainstaluje SQL Server na Windowsie i stworzy bazę danych ręcznie.
- Jeśli aplikacja nie działa, to pewnie baza nie działa.
- Jeśli baza danych się nie uruchamia, `docker container logs IODatabase` aby zdiagnozować problem.
- Jeśli ktoś używa Docker Toolbox, to zmienić IP w connection stringu na `192.168.99.100`

### Jak sprawdzić czy to działa?
Po uruchomieniu aplikacji za pomocą przycisku 'Play' w IntelliJ, strona powinna być dostępna pod adresem `localhost:8080/tickets`.

### Jak pracujemy?
Tworzymy osobnego brancha, gdy skończymy kawałek swojej pracy robimy Pull Requesta, żeby to zintegrować.

### Stos Technologiczny
- Spring Boot MVC
- Spring JPA -> Hibernate (baza danych)
- Spring Security
- MSSQL Server
