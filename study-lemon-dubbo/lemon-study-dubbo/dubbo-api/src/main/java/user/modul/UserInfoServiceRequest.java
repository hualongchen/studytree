package user.modul;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


/**
 5      * Bean Validation 中内置的 constraint
 6      * @Null   被注释的元素必须为 null
 7      * @NotNull    被注释的元素必须不为 null
 8      * @AssertTrue     被注释的元素必须为 true
 9      * @AssertFalse    被注释的元素必须为 false
 10      * @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 11      * @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 12      * @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 13      * @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 14      * @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
 15      * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
 16      * @Past   被注释的元素必须是一个过去的日期
 17      * @Future     被注释的元素必须是一个将来的日期
 18      * @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式
 19      * Hibernate Validator 附加的 constraint
 20      * @NotBlank(message =)   验证字符串非null，且长度必须大于0
 21      * @Email  被注释的元素必须是电子邮箱地址
 22      * @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内
 23      * @NotEmpty   被注释的字符串的必须非空
 24      * @Range(min=,max=,message=)  被注释的元素必须在合适的范围内
 25      */


/**
 * @author :chenhualong
 * @Date : created in 15:20 2017/12/27
 */

@Data
public class UserInfoServiceRequest  implements Serializable{

    private int  userId ;

    @NotBlank
    @Length(min = 2,max = 15,message = "手机号太长了，不太好")
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$" ,message = "手机格式不对哟")
    private String mobilePhone ;


    @Min(value = 18,message = "必须年满18岁")
    @Range(min=18,max = 30,message = "18到30岁之间")
    private int age ;


    @Email(message = "邮箱格式要正确")
    private String email ;

    @AssertTrue(message = "你必须是男孩才能用")
    private boolean boy ;

    @AssertFalse(message = "你必须不是女孩才能用")
    private boolean girl ;

    @Past(message = "你的时间必须是过去的日期")
    private Date   pastTime ;

    @Future(message = "你的时间必须是未来的日期")
    private Date futureTime ;

}
