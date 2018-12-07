package com.eci.cosw.springbootsecureapi.controller;

import com.eci.cosw.springbootsecureapi.model.User;
import com.eci.cosw.springbootsecureapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Santiago Carrillo
 * 8/21/17.
 */
@RestController
@RequestMapping( "user" )
public class UserController
{

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping( value = "/getAll", method = RequestMethod.GET )
    public List<User> getAllObjetosOfrecidos() {
        return userService.getUsers();
    }


    @CrossOrigin
    @RequestMapping( value = "/getPermission/{cc}", method = RequestMethod.GET )
    public String getUserPermission(@PathVariable String cc) {
        return userService.getUserPermission(cc);
    }

    @CrossOrigin
    @RequestMapping( value = "/byCC/{cc}", method = RequestMethod.GET )
    public User getUserByCC(@PathVariable String cc) {
        return userService.getUser(cc);
    }

    @CrossOrigin
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> newUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.ACCEPTED);
    }


    @CrossOrigin
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public ResponseEntity<?> login(@RequestBody User login ) {


        String jwtToken = "";

        if ( login.getCc() == null || login.getPassword() == null )
        {
            return new ResponseEntity<>( "Please fill in CC and password", HttpStatus.FORBIDDEN );
        }

        String cc = login.getCc();
        String password = login.getPassword();

        System.out.println(cc+" "+password);

        User user = userService.getUser(cc);
        System.out.println(user.getPassword()+ "HAAAAAAAAAAAOOOOOOOOOOOOOOOOOOOOOOO");

        if ( user != null )
        {
            String pwdNur = user.getPassword();

            if ( !password.equals( pwdNur ) )
            {
                System.out.println("clave mal 2");
                return new ResponseEntity<>( "Invalid login. Please check your name and password.", HttpStatus.FORBIDDEN );
            }
            jwtToken = Jwts.builder().setSubject( cc ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
                    SignatureAlgorithm.HS256, "secretkey" ).compact();
            System.out.println(jwtToken+" TOkern");
            return new ResponseEntity<>( new Token (jwtToken) ,HttpStatus.ACCEPTED);

        }

        return new ResponseEntity<>("User CC not found." ,HttpStatus.FORBIDDEN);

    }

    public class Token
    {

        String access_token;


        public Token( String access_token )
        {
            this.access_token = access_token;
        }


        public String getAccessToken()
        {
            return access_token;
        }

        public void setAccessToken( String access_token )
        {
            this.access_token = access_token;
        }
    }

}
