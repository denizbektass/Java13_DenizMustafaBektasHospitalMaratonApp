package com.dennis.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR(1000, "Sunucuda beklenmeye hata oluştu, lütfen terar deneyiniz",HttpStatus.INTERNAL_SERVER_ERROR),
    ERROR_DUPLICATE_USERNAME(2000,"Bu Kullanıcı adı zaten kayıtlıdır. Lütfen değiştirerek tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    BAD_REQUEST_ERROR(1001, "Girilen parametreler hatalıdır. Lütfen düzelterek tekrar deneyiniz", HttpStatus.BAD_REQUEST),
    ERROR_INVALID_LOGIN_PARAMETER(3000,"Kullanıcı adı ya da şifre hatalıdır. Lütfen düzelterek tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    ERROR_INVALID_DOCTOR_ID(4000,"Böyle bir doktor bulunamadı. Lütfen geçerli bir doktor giriniz.",HttpStatus.BAD_REQUEST),
    ERROR_NOT_ACTIVE_DOCTOR(5000,"Bu doktor şu anda aktif bir durumda değildir. Lütfen bu doktor için başka bir güne randevu alınız veya işleminize başka bir doktorla devam edebilirsiniz.", HttpStatus.BAD_REQUEST),
    ERROR_DUPLICATE_IDENTITY_NUMBER(2001, "Bu tc kimlik numarası size ait değildir. Lütfen tekrar deneyiniz.", HttpStatus.BAD_REQUEST),
    ERROR_INVALID_DOCTOR_NAME(6000, "Böyle bir doktor bulunamadı. Lütfen geçerli bir doktor giriniz.", HttpStatus.BAD_REQUEST);

    int code;
    String message;
    HttpStatus httpStatus;
}
