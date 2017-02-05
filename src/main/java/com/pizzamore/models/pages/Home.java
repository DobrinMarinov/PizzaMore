package com.pizzamore.models.pages;

import com.pizzamore.models.cookies.Cookie;
import com.pizzamore.models.header.Header;
import com.pizzamore.utils.WebUtils;

import java.util.HashMap;
import java.util.Map;

public class Home {

    private static Map<String, String> parameters;

    private static Map<String, Cookie> cookies;

    private static Header header;

    static {
        parameters = new HashMap<>();
        cookies = new HashMap<>();
        header = new Header();
    }

    public static void main(String[] args) {
        //get parameters
        getPageParameters();
        //print header
        Home.header.printHeader();
        //get cookies
        getCookies(args);
        //print html
        printHtml();
    }

    private static void printHtml() {
        Cookie languageCookie = Home.cookies.get("lang");
        if(languageCookie != null) {
            String language = languageCookie.getCookieValue();
            switch (language) {
                case "EN":
                    printHtmlEn();
                    break;
                case "DE":
                    printHtmlDe();
                    break;

            }
        } else {
            printHtmlEn();
        }
    }

    private static void getCookies(String[] cookies) {
        for (String cookie : cookies) {
            String[] tokens = cookie.split("=");
            String name = tokens[0];
            String value = tokens[1];
            Cookie cookieObject = new Cookie(name, value);
            Home.cookies.put(name, cookieObject);
        }
    }

    private static void getPageParameters() {
        Home.parameters = WebUtils.getParameters();
        for (String parameter : parameters.keySet()) {
            switch (parameter) {
                case "signup":
                    goToSignUp();
                    break;
                case "signin":
                    goToSignIn();
                    break;
                case "language":
                    setCookie();
                    break;
            }
        }
    }

    private static void setCookie() {
        String languageValue = parameters.get("language");
        Cookie cookie = new Cookie("lang", languageValue);
        header.setCookie(cookie);
    }

    private static void goToSignIn() {
        Home.header.setLocation("signin.cgi");
    }

    private static void goToSignUp() {
        Home.header.setLocation("signup.cgi");
    }

    private static void printHtmlEn() {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial scale=1\"/>\n" +
                "    <title>Home</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/bootstrap/css/bootstrap.min.css\"/>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/home.css\"/>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <div class=\"container-fluid\">\n" +
                "        <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n" +
                "            <ol class=\"carousel-indicators\">\n" +
                "                <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n" +
                "                <li data-target=\"#myCarousel\" data-slide-to=\"0\"></li>\n" +
                "            </ol>\n" +
                "            <div class=\"carousel-inner\" role=\"listbox\">\n" +
                "                <div class=\"item active\">\n" +
                "                    <img src=\"/images/pizza_1.jpg\" alt=\"Pizza1\">\n" +
                "                </div>\n" +
                "                <div class=\"item\">\n" +
                "                    <img src=\"/images/pizza_2.jpg\" alt=\"Pizza2\">\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <nav id=\"navigation\" class=\"navbar navbar-default\">\n" +
                "            <div class=\"container\">\n" +
                "                <div class=\"navbar-header\">\n" +
                "                    <a class=\"navbar-brand\">PizzaMore</a>\n" +
                "                </div>\n" +
                "                <form method=\"post\">\n" +
                "                    <input class=\"btn btn-primary\" type=\"submit\" name=\"language\" value=\"DE\"/>\n" +
                "                    <input class=\"btn btn-success\" type=\"submit\" name=\"signin\" value=\"Sign In\"/>\n" +
                "                    <input class=\"btn btn-warning\" type=\"submit\" name=\"signup\" value=\"Sign Up\"/>\n" +
                "\n" +
                "                </form>\n" +
                "            </div>\n" +
                "        </nav>\n" +
                "\n" +
                "    </div>\n" +
                "\n" +
                "    <script type=\"javascript\" src=\"/jquery/jquery.min.js\"></script>\n" +
                "    <script type=\"javascript\" src=\"/bootstrap/js/bootstrap.min.js\"></script>\n" +
                "</body>\n" +
                "</html>";
        System.out.println(html);
    }

    private static void printHtmlDe() {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial scale=1\"/>\n" +
                "    <title>Home</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/bootstrap/css/bootstrap.min.css\"/>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/home.css\"/>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <div class=\"container-fluid\">\n" +
                "        <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n" +
                "            <ol class=\"carousel-indicators\">\n" +
                "                <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n" +
                "                <li data-target=\"#myCarousel\" data-slide-to=\"0\"></li>\n" +
                "            </ol>\n" +
                "            <div class=\"carousel-inner\" role=\"listbox\">\n" +
                "                <div class=\"item active\">\n" +
                "                    <img src=\"/images/pizza_1.jpg\" alt=\"Pizza1\">\n" +
                "                </div>\n" +
                "                <div class=\"item\">\n" +
                "                    <img src=\"/images/pizza_2.jpg\" alt=\"Pizza2\">\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <nav id=\"navigation\" class=\"navbar navbar-default\">\n" +
                "            <div class=\"container\">\n" +
                "                <div class=\"navbar-header\">\n" +
                "                    <a class=\"navbar-brand\">PizzaMore</a>\n" +
                "                </div>\n" +
                "                <form method=\"post\">\n" +
                "                    <input class=\"btn btn-primary\" type=\"submit\" name=\"language\" value=\"EN\"/>\n" +
                "                    <input class=\"btn btn-success\" type=\"submit\" name=\"signin\" value=\"Anmelden\"/>\n" +
                "                    <input class=\"btn btn-warning\" type=\"submit\" name=\"signup\" value=\"Unterschreiben\"/>\n" +
                "\n" +
                "                </form>\n" +
                "            </div>\n" +
                "        </nav>\n" +
                "\n" +
                "    </div>\n" +
                "\n" +
                "    <script type=\"javascript\" src=\"/jquery/jquery.min.js\"></script>\n" +
                "    <script type=\"javascript\" src=\"/bootstrap/js/bootstrap.min.js\"></script>\n" +
                "</body>\n" +
                "</html>";
        System.out.println(html);
    }

}
