package com.benforsberg.certmanager.Cert;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertRepository extends JpaRepository<Cert,Long> {
}
