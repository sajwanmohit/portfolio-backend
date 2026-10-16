package com.mohit.portfolio_backend.controller;

import com.mohit.portfolio_backend.config.SecurityConfig;
import com.mohit.portfolio_backend.entity.Profile;
import com.mohit.portfolio_backend.filter.JwtFilter;
import com.mohit.portfolio_backend.service.CustomUserDetailsService;
import com.mohit.portfolio_backend.service.ProfileService;
import com.mohit.portfolio_backend.utility.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = com.mohit.portfolio_backend.controller.Admin.AdminProfileController.class)
@Import({SecurityConfig.class, JwtFilter.class, JwtUtil.class})
class AdminProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtUtil jwtUtil;

    @MockBean
    private ProfileService profileService;

    @MockBean
    private CustomUserDetailsService userDetailsService;

    @BeforeEach
    void authenticateJwtSubject() {
        when(userDetailsService.loadUserByUsername("admin"))
                .thenReturn(User.withUsername("admin").password("unused").roles("ADMIN").build());
    }

    @Test
    void getProfileReturnsSavedValuesAtTopLevelForAuthenticatedAdmin() throws Exception {
        when(profileService.getProfile()).thenReturn(Profile.builder()
                .name("Jane Doe")
                .designation("Developer")
                .about("About Jane")
                .ownerGithubProfileURL("https://github.com/jane")
                .ownerLinkedinProfileURL("https://linkedin.com/in/jane")
                .ownerEmailAddress("jane@example.com")
                .build());

        mockMvc.perform(get("/api/admin/profile")
                        .header(HttpHeaders.AUTHORIZATION, adminAuthorization()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane Doe"))
                .andExpect(jsonPath("$.designation").value("Developer"))
                .andExpect(jsonPath("$.about").value("About Jane"))
                .andExpect(jsonPath("$.ownerGithubProfileURL").value("https://github.com/jane"))
                .andExpect(jsonPath("$.ownerLinkedinProfileURL").value("https://linkedin.com/in/jane"))
                .andExpect(jsonPath("$.ownerEmailAddress").value("jane@example.com"))
                .andExpect(jsonPath("$.profile").doesNotExist())
                .andExpect(jsonPath("$.data").doesNotExist());
    }

    @Test
    void getProfileReturnsEmptyFieldsWhenNoProfileExists() throws Exception {
        when(profileService.getProfile()).thenReturn(null);

        mockMvc.perform(get("/api/admin/profile")
                        .header(HttpHeaders.AUTHORIZATION, adminAuthorization()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(""))
                .andExpect(jsonPath("$.designation").value(""))
                .andExpect(jsonPath("$.about").value(""))
                .andExpect(jsonPath("$.ownerGithubProfileURL").value(""))
                .andExpect(jsonPath("$.ownerLinkedinProfileURL").value(""))
                .andExpect(jsonPath("$.ownerEmailAddress").value(""));
    }

    @Test
    void getProfileConvertsNullableSavedFieldsToEmptyStrings() throws Exception {
        when(profileService.getProfile()).thenReturn(Profile.builder()
                .name("Jane Doe")
                .build());

        mockMvc.perform(get("/api/admin/profile")
                        .header(HttpHeaders.AUTHORIZATION, adminAuthorization()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane Doe"))
                .andExpect(jsonPath("$.designation").value(""))
                .andExpect(jsonPath("$.about").value(""))
                .andExpect(jsonPath("$.ownerGithubProfileURL").value(""))
                .andExpect(jsonPath("$.ownerLinkedinProfileURL").value(""))
                .andExpect(jsonPath("$.ownerEmailAddress").value(""));
    }

    @Test
    void getProfileRejectsUnauthenticatedRequests() throws Exception {
        mockMvc.perform(get("/api/admin/profile"))
                .andExpect(status().isForbidden());
    }

    private String adminAuthorization() {
        return "Bearer " + jwtUtil.generateToken("admin", "ADMIN");
    }
}
