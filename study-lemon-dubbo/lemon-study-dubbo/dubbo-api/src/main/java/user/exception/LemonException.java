package user.exception;

/**
 * @author :chenhualong
 * @Date : created in 17:57 2017/12/28
 * @Description :
 */
public class LemonException  extends RuntimeException{


    private String code;


    String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LemonException(String code, String message) {

        super(message);
        this.code = code;

    }



}
