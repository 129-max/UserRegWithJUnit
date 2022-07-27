public class UserRegistration {

        private static final String nameFormat = "[A-Z][a-z]{2,}";
        private static final String emailFormat = "^[0-9a-zA-Z]+([._+-][0-9a-zA-Z]+)*[@][0-9A-Za-z]+([.][a-zA-Z]{2,4})*$";
        private static final String mobileFormat = "^[0-9]{1,2}[ ][0-9]{10}$";
        private static final String passwordFormat = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[*.!@#$%^&(){}:'<>,.>/~`_+=|].).{8,}$";

        ValidateUserDetailFunction userDetailFunction = (x, y) -> x.matches(y);

        public String validateFName(String fName) throws InvalidDetailExceptions {
            try {
                if(userDetailFunction.validate(fName, nameFormat) == true) {
                    return "Success";
                }
                else {
                    throw new InvalidDetailExceptions(InvalidDetailExceptions.ExceptionType.ENTERED_INVALID, "Invalid first name format");
                }
            }catch (NullPointerException e) {
                throw new InvalidDetailExceptions(InvalidDetailExceptions.ExceptionType.ENTERED_NULL, "Don't pass null value");
            }
        }

        public String validateLName(String lName) throws InvalidDetailExceptions {
            try {
                if(userDetailFunction.validate(lName, nameFormat) == true){
                    return "Success";
                }else {
                    throw new InvalidDetailExceptions(InvalidDetailExceptions.ExceptionType.ENTERED_INVALID, "Invalid last name format");
                }
            }catch (NullPointerException e) {
                throw new InvalidDetailExceptions(InvalidDetailExceptions.ExceptionType.ENTERED_NULL, "Don't pass null value");
            }
        }

        public String validateEmailId(String email) throws InvalidDetailExceptions {
            try {
                if(userDetailFunction.validate(email, emailFormat)) {
                    return "Success";
                }
                else {
                    throw new InvalidDetailExceptions(InvalidDetailExceptions.ExceptionType.ENTERED_INVALID, "Invalid email format");
                }
            }
            catch (NullPointerException e) {
                throw new InvalidDetailExceptions(InvalidDetailExceptions.ExceptionType.ENTERED_NULL, "Don't pass null value");
            }
        }
        public String validatePhoneNumber(String phone) throws InvalidDetailExceptions {
            try {
                if (userDetailFunction.validate(phone, mobileFormat) == true)
                {
                    return "Success";
                }
                else {
                    throw new InvalidDetailExceptions(InvalidDetailExceptions.ExceptionType.ENTERED_INVALID,"Provide valid mobile number format");
                }
            }catch (NullPointerException e) {
                throw new InvalidDetailExceptions(InvalidDetailExceptions.ExceptionType.ENTERED_NULL, "Don't pass null value");
            }
        }

        public String validatePassword(String passcode) throws InvalidDetailExceptions {
            try {
                if (userDetailFunction.validate(passcode, passwordFormat))
                {
                    return "Success";
                }
                else {
                    throw new InvalidDetailExceptions(InvalidDetailExceptions.ExceptionType.ENTERED_INVALID, "Provide valid password Format");
                }
            }catch (NullPointerException e){
                throw new InvalidDetailExceptions(InvalidDetailExceptions.ExceptionType.ENTERED_NULL, "Don't pass null value");
            }
        }

        public String moodAnalyse(String fName, String lName, String phoneNumber, String email, String password ) throws InvalidDetailExceptions {
            try{
                if(validateFName(fName) == "Success" && validateLName(lName) == "Success" && validateEmailId(email) == "Success" && validatePhoneNumber(phoneNumber) == "Success" && validatePassword(password) == "Success"){
                    return "HAPPY";
                }
                else {
                    return "SAD";
                }
            }
            catch (NullPointerException e)
            {
                throw new InvalidDetailExceptions(InvalidDetailExceptions.ExceptionType.ENTERED_NULL, "Dont pass null value");
            }
        }
    }

