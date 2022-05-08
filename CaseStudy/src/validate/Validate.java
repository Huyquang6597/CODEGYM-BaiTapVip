package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
public boolean validate(DetailValidate detailValidate , String string){
    Pattern pattern = Pattern.compile(detailValidate.getRegex());
    Matcher matcher = pattern.matcher(string);
    if(!matcher.matches()){
        System.out.println(detailValidate.getMessage());
    } return matcher.matches();
}

}
