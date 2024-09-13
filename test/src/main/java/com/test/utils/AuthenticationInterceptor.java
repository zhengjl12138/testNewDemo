//package com.test.utils;
//
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import com.auth0.jwt.exceptions.AlgorithmMismatchException;
//import com.auth0.jwt.exceptions.SignatureVerificationException;
//import com.auth0.jwt.exceptions.TokenExpiredException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.test.service.UserService;
//
//public class AuthenticationInterceptor implements HandlerInterceptor {
//    @Autowired
//    UserService userService;
//
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
//        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
//        // 如果不是映射到方法直接通过
//        if (!(object instanceof HandlerMethod)) {
//            return true;
//        }
//        HandlerMethod handlerMethod = (HandlerMethod) object;
//        Method method = handlerMethod.getMethod();
//
//        //检查有没有需要用户权限的注解
//        if (method.isAnnotationPresent(TokenRequired.class)) {
//            TokenRequired userLoginToken = method.getAnnotation(TokenRequired.class);
//            if (userLoginToken.required()) {
//
//                Map<String,Object> map = new HashMap<>();
//                // 获取请求头中令牌
//                System.out.println(token);
//                try {
//                    // 验证令牌
//                    JwtUtil.verify(token);
//                    return true;  // 放行请求
//                } catch (SignatureVerificationException e) {
//                    e.printStackTrace();
//                    map.put("msg","无效签名！");
//                }catch (TokenExpiredException e){
//                    e.printStackTrace();
//                    map.put("msg","token过期");
//                }catch (AlgorithmMismatchException e){
//                    e.printStackTrace();
//                    map.put("msg","算法不一致");
//                }catch (Exception e){
//                    e.printStackTrace();
//                    map.put("msg","token无效！");
//                }
//                map.put("state",false);  //设置状态
//                // 将map以json的形式响应到前台  map --> json  (jackson)
//                String json = new ObjectMapper().writeValueAsString(map);
//                httpServletResponse.setContentType("application/json;charset=UTF-8");
//                httpServletResponse.getWriter().println(json);
//                return false;
//
//            }
//        }
//        return true;
//    }
//}