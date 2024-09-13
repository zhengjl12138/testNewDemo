package com.test.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
	public User(int i, String username2, String password2) {
		// TODO 自动生成的构造函数存根
	}
	private static final long serialVersionUID = -8390887042859558153L;
    private Integer id;
    private String username;
    private String password;
    private String realname;
    private String phone;
    private String email;
    private String grants;
    private String remark;
    private String create_time;
    private String update_time;

    
}


