package com.anurag.smartcampus;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = {
    "http://127.0.0.1:5500",
    "https://smartcampuscompliantmanagmentsystem.vercel.app"
})
public class ComplaintController {

    private final ComplaintRepository complaintRepository;

    public ComplaintController(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @PostMapping
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        complaint.setStatus("PENDING");
        Complaint savedComplaint = complaintRepository.save(complaint);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedComplaint);
    }

    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaint(@PathVariable Long id) {
        return complaintRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {

        return complaintRepository.findById(id)
                .map(complaint -> {
                    String status = request.get("status");

                    if (status == null || status.isBlank()) {
                        return ResponseEntity.badRequest().body("Status is required.");
                    }

                    complaint.setStatus(status.toUpperCase());
                    return ResponseEntity.ok(complaintRepository.save(complaint));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
