package com.pizzamore.models.pages;

import com.pizzamore.models.cookies.Cookie;
import com.pizzamore.models.header.Header;
import com.pizzamore.models.users.User;
import com.pizzamore.repository.UserRepository;
import com.pizzamore.utils.WebUtils;

import java.util.HashMap;
import java.util.Map;

public class SignUp {

    private static Map<String, String> parameters;

    private static Header header;

    private static UserRepository userRepository;

    static {
        parameters = new HashMap<>();
        header = new Header();
        userRepository = new UserRepository();
    }

    public static void main(String[] args) {
        //get params
        getPageParameters();
        //print header
        header.printHeader();
        //print html
        printHtml();
        
    }



    private static void getPageParameters() {
        SignUp.parameters = WebUtils.getParameters();
        for (String parameter : parameters.keySet()) {
            switch (parameter) {
                case "signup":
                    String username = parameters.get("username");
                    String password = parameters.get("password");
                    createUser(username, password);
                    goToSignInPage();
                    break;
                case "home":
                    goToHomePage();
                    break;

            }
        }

    }

    private static void goToSignInPage() {
    }

    private static void createUser(String username, String password) {
        User user = new User(username, password);
        SignUp.userRepository.createUser(user);
    }

    private static void goToHomePage(){
        SignUp.header.setLocation("home.cgi");
    }

    private static void printHtml() {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial scale=1\"/>\n" +
                "    <title>Sign Up</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/bootstrap/css/bootstrap.min.css\"/>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/signup.css\"/>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container-fluid\">\n" +
                "        <div class=\"jumbotron\">\n" +
                "            <form method=\"post\" class=\"form-horizontal\">\n" +
                "\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label class=\"control-label col-sm-2 col-sm-offset-2\">Username</label>\n" +
                "                    <div class=\"col-sm-3\">\n" +
                "                        <input class=\"form-control\" type=\"text\" name=\"username\">\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label class=\"control-label col-sm-2 col-sm-offset-2\">Password</label>\n" +
                "                    <div class=\"col-sm-3\">\n" +
                "                        <input class=\"form-control\" type=\"password\" name=\"password\">\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"form-group\">\n" +
                "                    <div class=\"col-sm-4 col-sm-offset-4\">\n" +
                "                        <input class=\"btn btn-success\" type=\"submit\" name=\"signup\" value=\"Sign Up\">\n" +
                "                        <input class=\"btn btn-danger\" type=\"submit\" name=\"home\" value=\"Home\">\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "    <script type=\"javascript\" src=\"/jquery/jquery.min.js\"></script>\n" +
                "    <script type=\"javascript\" src=\"/bootstrap/js/bootstrap.min.js\"></script>\n" +
                "</body>\n" +
                "</html>";
        System.out.println(html);
    }

}
