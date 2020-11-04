    @Bean
    public SingleLogoutProfile logoutprofile() {
         SingleLogoutProfileImpl logoutProfile = new CustomSingleLogoutProfile();
         logoutProfile.setResponseSkew((int)TimeUnit.HOURS.toSeconds(24));
         return  logoutProfile;
    }

    @Bean
    public WebSSOProfileConsumer webSSOprofileConsumer() {
        final WebSSOProfileConsumerImpl consumer = new WebSSOProfileConsumerImpl();
        Duration duration = ssoService.getProperties().getMaxAuthenticationAge();
        log.info("setting sso property max authentication age: {} in seconds", duration.getSeconds());
        consumer.setMaxAuthenticationAge(duration.getSeconds());
        consumer.setResponseSkew((int)TimeUnit.HOURS.toSeconds(24)); //time in seconds
        return consumer;
    }
