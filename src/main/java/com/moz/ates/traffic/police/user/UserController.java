package com.moz.ates.traffic.police.user;

import com.moz.ates.traffic.police.common.DataTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "newUserRegist")
    public String newUserRegist(Model model){

        return "UserRegist";
    }

    @RequestMapping(value = "userRegistAjax")
    @ResponseBody
    public Map<String,Object> userRegistAjax(@ModelAttribute UserVO userVO, Principal principal){
        Map<String, Object> result = new HashMap<>();
        int dupliUserChk = userService.getDupliChk(userVO);

        if(dupliUserChk > 0){
            result.put("code", "-1");
            result.put("msg", "중복된 아이디가 있습니다.");
        }else{
            try {
                System.out.println(principal.getName());
                userVO.setCrtr(principal.getName());
                if(userVO.getOprtrAccountPw() != null && !userVO.getOprtrAccountPw().isEmpty()){
                    userVO.setOprtrAccountPw(passwordEncoder.encode(userVO.getOprtrAccountPw()));
                }
                userService.registUser(userVO);
                result.put("code", "1");
            }catch (Exception e){
                result.put("code", "0");
                result.put("msg", e.getMessage());
            }

        }


        return result;
    }


    @RequestMapping(value = "userList")
    public String userList(Model model,@ModelAttribute UserVO userVO){

        model.addAttribute("userVO",userVO);
        return "UserList";
    }


    @PostMapping(value = "userListAjax")
    @ResponseBody
    public DataTableVO userListAjax(@ModelAttribute UserVO userVO){


        return userService.getUserListDatatable(userVO);
    }

    @RequestMapping(value = "userDetail")
    public String mngDetail(Model model, @RequestParam("oprtrId")String oprtrId){

        UserVO userVO = userService.getUserDetail(oprtrId);
        model.addAttribute("userVO", userVO);

        return "UserDetail";
    }
    @RequestMapping(value = "userModify")
    public String mngModify(Model model, @RequestParam("oprtrId")String oprtrId){

        UserVO userVO = userService.getUserDetail(oprtrId);
        model.addAttribute("userVO", userVO);

        return "UserModify";
    }



    @RequestMapping(value = "userModifyAjax")
    @ResponseBody
    public Map<String,Object> userModifyAjax(@ModelAttribute UserVO userVO){
        Map<String, Object> result = new HashMap<>();
        try {
            if(userVO.getOprtrAccountPw() != null && !userVO.getOprtrAccountPw().isEmpty()){
                userVO.setOprtrAccountPw(passwordEncoder.encode(userVO.getOprtrAccountPw()));
            }
            userService.updateUser(userVO);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
            result.put("msg", e.getMessage());
        }

        return result;
    }




}
