package com.ldblockchain.sls.comm.handler;

import com.ldblockchain.sls.comm.enums.ResultCode;
import com.ldblockchain.sls.comm.result.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult defaultErrorHandler(HttpServletRequest req, Exception e)  {

//      // If the exception is annotated with @ResponseStatus rethrow it and let
//      // the framework handle it - like the OrderNotFoundException example
//      // at the start of this post.
//      // AnnotationUtils is a Spring Framework utility class.
//      if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
//          throw e;
//
//      // Otherwise setup and send the user to a default error-view.
//      ModelAndView mav = new ModelAndView();
//      mav.addObject("exception", e);
//      mav.addObject("url", req.getRequestURL());
//      mav.setViewName(DEFAULT_ERROR_VIEW);
//      return mav;

        //打印异常信息：
//        e.printStackTrace();

        logger.error("ERROR CODE:" + ResultCode.getCode(e.getMessage()) + " ERROR MESSAGE:" + e.getMessage());

        return ResponseResult.failure(ResultCode.getCode(e.getMessage()),ResultCode.getMessage(e.getMessage()));
    }
}
