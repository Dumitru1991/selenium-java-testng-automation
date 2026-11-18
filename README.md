# UI Automation - Java + Maven + TestNG + Selenium

## Cerinte
- JDK 21
- Maven 3.8+ (sau Maven Wrapper, daca il adaugi)
- Google Chrome instalat
- Conexiune la internet la prima rulare, pentru descarcarea dependentelor Maven si, daca este necesar, a driverului Chrome.

## Deschidere in IntelliJ IDEA
1. Dezarhiveaza proiectul.
2. Alege File > Open si selecteaza directorul `UiAutomationMaven`.
3. Daca IntelliJ intreaba, importa proiectul ca Maven project.
4. Verifica Project SDK = JDK 21.
5. Deschide `pom.xml` si apasa Load Maven Changes daca este afisat.

## Rulare
Din terminal, in directorul proiectului:
    mvn clean test

Sau ruleaza `GoogleTest` / `testng.xml` din IntelliJ.

## Ce face testul
- `BaseTest` porneste Chrome inaintea fiecarui test.
- `GoogleTest` deschide https://www.google.com si verifica URL-ul.
- `BaseTest.tearDown()` inchide browserul dupa test, inclusiv daca testul esueaza.

Selenium 4 include Selenium Manager. In mod normal nu trebuie sa descarci manual `chromedriver`; Selenium Manager incearca sa gaseasca sau sa descarce driverul potrivit. Chrome trebuie sa fie instalat.
