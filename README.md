# Spring custom type converter

 The Converter interface requires that an implementation specify two type parameters, the first being the type you are converting from, the second being the type you are converting to. In this case it converts a String to a LocalDate.

### Project structure
In [src](./src) directory is tree
```
$ tree
.
├── main
│   ├── java
│   │   └── com
│   │       └── example
│   │           └── data
│   │               ├── controllers
│   │               │   └── OrderController.java
│   │               ├── converters
│   │               │   └── LocalDateConverter.java
│   │               ├── models
│   │               │   └── Order.java
│   │               └── SpringCustomTypeConverterApplication.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── com
            └── example
                └── data
                    └── SpringCustomTypeConverterApplicationTests.java

14 directories, 6 files
```
### Calss LocalDateConverter
It is a very simple converter
```Java
@Component
public class LocalDateConverter implements Converter<String, LocalDate> {

	/**
	 * Override the convert method
	 * 
	 * @param date
	 * @return LocalDate in BASIC_ISO_DATE
	 */
	@Override
	public LocalDate convert(String date) {
		return LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
	}
}
```
 The Converter 
```
 curl http://localhost:8080/orders/order/20200725
 {"carg":64.99,"description":"TP-Link AC1750 Smart WiFi Router - Dual Band Gigabit Wireless Internet Router for Home, Works with Alexa, VPN Server, Parental Control&QoS (Archer A7).","data":"2020-07-25"}
 ```

The converter converted the string "20200725" to LocalDate "2020-07-25"

Class SpringCustomTypeConverterApplicationTests is test class.