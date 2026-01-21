package com.codetrustitservices.service;

import com.codetrustitservices.model.Enquiry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnquiryService {

    private final List<Enquiry> enquiries = new ArrayList<>();
    private int counter  = 1;

    public void addEnquiry(Enquiry enquiry){
        enquiry.setId(counter++);
        enquiries.add(enquiry);
    }

    public List<Enquiry> getAllEnquiry(){
        return enquiries;
    }

    public void deleteEnquiry(int id){
        enquiries.removeIf(e -> e.getId() == id);
    }

    public Enquiry getEnquiryById(int id) {
        for (Enquiry e : enquiries) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public void updateEnquiry(Enquiry updatedEnquiry) {
        for (Enquiry e : enquiries) {
            if (e.getId() == updatedEnquiry.getId()) {
                e.setName(updatedEnquiry.getName());
                e.setEmail(updatedEnquiry.getEmail());
                e.setPhone(updatedEnquiry.getPhone());
                e.setMessage(updatedEnquiry.getMessage());
                break;
            }
        }
    }

}
