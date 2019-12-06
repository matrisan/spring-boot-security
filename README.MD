SecurityContextPersistenceFilter -> UsernamePasswordAuthenticationFilter -> BasicAuthenticationFilter -> .... ExceptionTranslationFilter-> FilterSecurityInterceptor -> Restful API






|登录请求
UsernamePasswordAuthenticationFilter
|  (Authentication未认证)
AuthenticationManager
|
AuthenticationProvider
|
UserDetailService
|
UserDetails
|

|
Authentication(已认证)
|
SecurityContext
|
SecurityContextHolder
|
SecurityContextPersistenceFilter
|








