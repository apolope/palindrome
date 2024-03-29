package br.com.a3sitsolutions.exceptions;

import br.com.a3sitsolutions.utils.MessagesUtil;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.Getter;

@Getter
public abstract class BaseHttpException extends RuntimeException {
    protected String message;
    protected HttpResponseStatus httpStatusCode;
    protected String detailMessage;

    public BaseHttpException(String message, HttpResponseStatus httpStatusCode) {
        super(message);
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

    public BaseHttpException(HttpResponseStatus httpStatusCode, MessagesUtil messageEnum) {
        super(messageEnum.getMessage());
        this.message = messageEnum.getMessage();
        this.httpStatusCode = httpStatusCode;
    }

    public BaseHttpException(HttpResponseStatus httpStatusCode, MessagesUtil messageEnum, String... args) {
        super(messageEnum.getMessage(args));
        this.message = messageEnum.getMessage(args);
        this.httpStatusCode = httpStatusCode;
    }

}
