# MICROSERVICES WITH SPRING BOOT 2

- CONFIG-SERVER
- DISCOVERY-SERVER
- API-GATEWAY
- USER-SERVICE
- AUTHENTICATION-SERVICE

## JWT authentication with [jjwt](https://github.com/jwtk/jjwt) library

```bash
POST http://localhost:8080/auth/register 
{
  "email":"test@gmail.com",
  "password":"*****",
  "name":"test"
}
```

Return something like this

```bash
{
  "accessToken":"eyJhbGciOiJIUzM4NCJ9.eyJpZCI6IjE2OTg3MTI1MDg3MDciLCJyb2xlIjoiVVNFUiIsInN1YiI6IjE2OTg3MTI1MDg3MDciLCJpYXQiOjE2OTg3MTI1MDgsImV4cCI6MTY5ODc5ODkwOH0.iSReJ89v9Uguu5uAUb95TiNX9-KrqofrUuhXJDCghDrH6TCao-RIYzD5dQc0yL70",
  "refreshToken":"eyJhbGciOiJIUzM4NCJ9.eyJpZCI6IjE2OTg3MTI1MDg3MDciLCJyb2xlIjoiVVNFUiIsInN1YiI6IjE2OTg3MTI1MDg3MDciLCJpYXQiOjE2OTg3MTI1MDgsImV4cCI6MTY5ODc5ODkwOH0.iSReJ89v9Uguu5uAUb95TiNX9-KrqofrUuhXJDCghDrH6TCao-RIYzD5dQc0yL70"
}
```

## Secure endpoint

```bash
GET http://localhost:8080/users/secured
{
  headers: {
    "Authorization" = "eyJhbGciOiJIUzM4NCJ9.eyJyb2xlIjoiVVNFUiIsImlkIjoiMTY5ODcxMzc5OTcxNyIsInN1YiI6IjE2OTg3MTM3OTk3MTciLCJpYXQiOjE2OTg3MTM3OTksImV4cCI6MTY5ODgwMDE5OX0.8KELxUn4aYf2dE2bSlow7iia-1Tw48EhQRQGnjo5jXW06X2kUT8e55vcydhqawrO"
  }
}
```