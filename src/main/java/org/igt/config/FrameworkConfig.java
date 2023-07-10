package org.igt.config;

import java.net.URL;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.ConverterClass;
import org.aeonbits.owner.Config.DefaultValue;
import org.aeonbits.owner.Config.Key;
import org.igt.converters.StringToURLConverter;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ 
	"system:properties", 
	"system:env",
	"file:${user.dir}/src/main/resources/config.properties"
	})
public interface FrameworkConfig extends Config {
		@Key("deviceIp")
		String deviceIp();
		
		@Key("port")
		String portno();
		
		@Key("PASSEDSTEPSSCREENSHOT")
		String isPassedScreenshotRequired();
		
		@Key("FAILEDSTEPSSCREENSHOT")
		String isFailedScreenshotRequired();
		
		@Key("OVERRIDEREPORTS")
		String isOverrideRequired(); 
		
		@DefaultValue("http://127.0.0.1:4723")
		@ConverterClass(StringToURLConverter.class)
		URL localWinAppDriverServerURL();
		
		@DefaultValue("No")
		@Key("sendresultstoelk")
		String isELKEnabled();
		
		@Key("elkdashboardurl")
		String elastickibanaUrl();
	
}
