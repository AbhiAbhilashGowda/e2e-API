package com.automation.util;

import org.apache.commons.lang.StringUtils;

import io.mail7.sdk.api.EmailApi;
import io.mail7.sdk.models.responsemodels.InboxResponse;
import io.mail7.sdk.util.AsyncHandler;
import io.mail7.sdk.util.ErrorResponse;
import io.mail7.sdk.util.Mail7SDK;

public class GetEMailUsingJavaMailFromMail7 {
	static String otp = null;

	public String getOTPfromMail(String email) {
  //e2ehiring@mail7.io API Credentials(Key and Secret) 
		Mail7SDK.Initialize sdk = new Mail7SDK.Initialize();
		sdk.setApiKey("5713cdc5-2d17-4b32-9016-077ec9b693b8");
		sdk.setApiSecret("d3d8718a-7295-42c6-8086-5f8a00183562");
		EmailApi Mail7EmailAPI = new EmailApi();
		System.out.println(email);

		Mail7EmailAPI.getEmails(email.replace("@mail7.io", ""), "", new AsyncHandler<InboxResponse>() {
			@Override
			public void onSuccess(InboxResponse response) {
				System.err.println(response.getData().toString());
				String temp = "<td style=\"font-weight:700;font-size:25px\"><span style=\"width:25%;background:#ff5733;padding:10px 25px;border-radius:1px;letter-spacing:5px;box-shadow:0px 0px 5px #00000040;color:#fff\">";
				int index = response.getData().toString().indexOf(temp);
				otp = response.getData().toString().substring(index + 185, index + 191);
				System.out.println("OTP is :" + otp);
			}

			@Override
			public void onFailure(ErrorResponse error) {
				System.out.println(error.getMessage());
			}
		});

		if (!StringUtils.isEmpty(otp)) {
			System.out.println(otp);

		}
		return otp;
	}

}