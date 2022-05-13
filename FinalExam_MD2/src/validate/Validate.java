package validate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String regexPhone = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
    private static final String regexEmail = "^[A-Z0-9+_.-]+@[A-Z0-9.-]+$";


        public boolean validate(DetailValidate detailValidate , String string){
            Pattern pattern = Pattern.compile(detailValidate.getRegex());
            Matcher matcher = pattern.matcher(string);
            if(!matcher.matches()){
                System.out.println(detailValidate.getMessage());
            } return matcher.matches();
        }

    }

