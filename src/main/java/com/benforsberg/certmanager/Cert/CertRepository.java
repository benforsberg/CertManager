package com.benforsberg.certmanager.Cert;

import com.benforsberg.certmanager.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertRepository extends JpaRepository<Cert, Long> {
    List<Cert> findByCertCode(String certCode);

    List<Cert> findByIsExpired(boolean isExpired);
}
