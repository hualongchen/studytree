package user.exception;



import com.alibaba.dubbo.rpc.RpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * 全局异常处理中心，所以异常均放在此处进行整理发送
 */

@ControllerAdvice
@ResponseBody
@SuppressWarnings("rawtypes")
public class CommonExceptionAdvice {


    private static Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);




    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResultVO handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        return new ResultVO(ErrorContent.PARAMETER_RESOLUTION_FAILURE_CDOE, ErrorContent.PARAMETER_RESOLUTION_FAILURE_MESSAGE);
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("参数验证失败", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String field = error.getField();
        String code = error.getDefaultMessage();
        String message = String.format("%s:%s", field, code);
        return new ResultVO(ErrorContent.PARAMETER_VALIDATION_FAILURE_CDOE,message);
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BindException.class)
    public ResultVO handleBindException(BindException e) {
        logger.error("参数绑定失败", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        //String field = error.getField();
        String code = error.getDefaultMessage();
       // String message = String.format("%s:%s", field, code);
        return new ResultVO(ErrorContent.PARAMETER_BINDING_FAILURE_CDOE,code);
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVO handleServiceException(ConstraintViolationException e) {
        logger.error("参数验证失败", e);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        return new ResultVO(ErrorContent.PARAMETER_VALIDATION_FAILURE_CDOE,message);
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ValidationException.class)
    public ResultVO handleValidationException(ValidationException e) {
        logger.error("参数验证失败", e);
        return new ResultVO(ErrorContent.PARAMETER_VALIDATION_FAILURE_CDOE, ErrorContent.PARAMETER_VALIDATION_FAILURE_MESSAGE);
    }





    /**
     * 500 - Internal Server Error
     */
    
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResultVO handleException(Exception e) {
        logger.error("通用异常", e);
        return new ResultVO(ErrorContent.GENEREL_ERROR_CDOE,e.getMessage());
    }



    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(LemonException.class)
    public ResultVO handleServiceException(LemonException e) {
        logger.error("业务逻辑异常", e);
        return new ResultVO(e.getCode(), e.getMessage());
    }



    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(RpcException.class)
    public ResultVO handleRPCException(RpcException e) {
        logger.error("业务逻辑异常", e);
        return new ResultVO(e.getCode()+"",e.getMessage());
    }



}
