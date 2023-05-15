package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.controller.AnnouncementController;

public class AnnouncementControllerTest 
{
    @Test
    public void Announcement() {
        AnnouncementController announcementController = new AnnouncementController();
        List<Announcement> output = announcementController.getAnnouncementsByStudentID("20182011");
        Ann expected_output = "study";
        assertTrue(output != expected_output);
    }
}
