package com.riderspoint.user_service.pojo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SocialDetails {
	public String linkedin_url;
	public String instagram_url;
	public String youtube_url;
}
