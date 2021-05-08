# selenium-instagram-login-example
***Simple Instagram Login Application With Selenium*** 

**Selenium WebDriver'ini Chrome üzerinde çalıştırmak için aşağıdaki driver'i indirmemiz gerekir.**

    https://chromedriver.chromium.org/downloads

**Jar dosyası oluşturmak için:**

Uygulamanın pom.xml'inin bulunduğu klasöre gidip aşağıdaki komutu çalıştırın.

    mvn package

**Uygulamayı çalıştırmak için:**

jarFileLocation, username, password bilgilerini yazarak aşağıdaki kodu çalıştırın.

    java -jar jarFileLocation\selenium-webdriver-example-0.0.1-SNAPSHOT.jar username password

**Sırasıyla:**

1) Google Chrome açılır.  
2) https://www.instagram.com adresine gidilir.  
3) jar'ı çalıştırırken verdiğiniz parametreler login sayfasındaki kullanıcı adı ve şifre alanına setlenir.  
4) Login olunur.
