package com.qhao.LAPTOPSHOP.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qhao.LAPTOPSHOP.domain.User;
import com.qhao.LAPTOPSHOP.service.RoleService;
import com.qhao.LAPTOPSHOP.service.UploadService;
import com.qhao.LAPTOPSHOP.service.UserService;

@Controller
public class UserController {
    private final UserService userService;
    private final UploadService uploadService;
    private final RoleService roleService;

    public UserController(UserService userService, UploadService uploadService, RoleService roleService) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.roleService = roleService;
    }

    // default method GET
    // admin request create user -> Controller(userpage.jsp) -> action: home
    @RequestMapping(value = "/admin/user")
    public String getAllUser(Model model) {
        model.addAttribute("listUser", userService.getAllUser());
        return "admin/user/show";
    }

    // control to page form-createuser.jsp
    // send model user(new & empty) from function createUser to page
    // form-createuser.jsp
    // page form-createuser.jsp: fill data in field input (path="id",...) -> user
    @GetMapping("/admin/user/create")
    public String createUser(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    // control from page form-createuser.jsp -> view-user (redirect)
    // after fill data in field input AND click button create -> user = newUser
    // @ModelAttribute is get user from form-createuser by modelAttribute="newUser"
    // function result: create new User
    @PostMapping("/create")
    public String result(@ModelAttribute("newUser") User user, @RequestParam("fileAvatar") MultipartFile file) {
        String nameAvatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        user.setRole(this.roleService.getRoleByName(user.getRole().getName()));
        user.setAvatar(nameAvatar);
        System.out.println(user);
        this.userService.createUser(user);
        return "redirect:admin/user";
    }

    // controller view user detail
    @GetMapping(value = "/admin/user/{id}")
    public String getUserDetail(@PathVariable long id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("imagePath", this.userService.getImagePath(this.userService.getUserById(id), "avatar"));
        return "admin/user/detail";
    }

    // controller update user
    @RequestMapping(value = "/admin/user/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/user/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateUserById(@ModelAttribute("user") User user) {
        User user1 = this.userService.getUserById(user.getId());
        if (!user1.equals(null)) {
            user1.setFullName(user.getFullName());
            user1.setPhone(user.getPhone());
            user1.setAddress(user.getAddress());
            this.userService.createUser(user1);
        }
        return "redirect:admin/user";
    }

    // controller delete user
    // return page delete-user.jsp -> add model user
    @GetMapping("/admin/user/delete/{id}")
    public String confirmDelete(@PathVariable long id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        System.out.println(this.userService.getUserById(id));
        return "admin/user/delete";
    }

    // after click button confirm
    // -> function deleteUser is going to get user(modelAttribute) from page
    // delete.jsp
    // -> delete user by id.
    @PostMapping(value = "/delete")
    public String deleteUser(@ModelAttribute("user") User user) {
        User userDelete = this.userService.getUserById(user.getId());
        this.userService.deleteUser(userDelete);
        return "redirect:admin/user";
    }
}
