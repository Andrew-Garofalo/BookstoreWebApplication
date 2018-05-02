package com.Bookstore.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateTime {
    String dateTime;

    @Override
    public String toString() {
        return dateTime;
    }
}
