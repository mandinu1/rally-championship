package com.example.rally_cross;

import javafx.fxml.FXML;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UPDControllerTest {

    @Test
    void updateValidation() {

            UPDController test = new UPDController();
            test.UpdateValidation("janusha");
    }
}

