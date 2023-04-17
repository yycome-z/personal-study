package main.java;

import javax.security.auth.x500.X500Principal;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author zhangyaoyuan
 * @date 2022/06/09
 */
public class TestCert {
    public static void main(String[] args) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException {
        /* 取出证书--从文件中取出 */
        String certpath = "C:\\Users\\15091\\Desktop\\wKi1umP-9tmAaMQmAAAB7QdsRbA7849804.cer";
        String substring = certpath.substring(0, 0);
        System.out.println("substring = " + substring);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        FileInputStream in1 = new FileInputStream(certpath);


        Certificate c = cf.generateCertificate(in1);
        Collection<? extends Certificate> certificates = cf.generateCertificates(in1);
        X509Certificate x509Cert = (X509Certificate) c;

        // JAVA程序中显示证书指定信息
        PublicKey publicKey = x509Cert.getPublicKey();
        X500Principal subjectX500Principal = x509Cert.getSubjectX500Principal();
        System.out.println(x509Cert.getSubjectX500Principal().getName());

        List<String> extendedKeyUsage = x509Cert.getExtendedKeyUsage();
        System.out.println("extendedKeyUsage = " + extendedKeyUsage);
        Collection<List<?>> subjectAlternativeNames = x509Cert.getSubjectAlternativeNames();
        System.out.println("subjectAlternativeNames = " + subjectAlternativeNames);
        Collection<List<?>> issuerAlternativeNames = x509Cert.getIssuerAlternativeNames();
        System.out.println("issuerAlternativeNames = " + issuerAlternativeNames);
        String sigAlgOID = x509Cert.getSigAlgOID();
        System.out.println("sigAlgOID = " + sigAlgOID);
        System.out.println("输出证书信息:"+c.toString());
        System.out.println("版本号:"+x509Cert.getVersion());
        System.out.println("序列号:"+x509Cert.getSerialNumber().toString(16));
        System.out.println("主体名："+x509Cert.getSubjectDN());
        System.out.println("签发者："+x509Cert.getIssuerDN());
        System.out.println("有效期："+x509Cert.getNotBefore());
        System.out.println("签名算法："+x509Cert.getSigAlgName());
        byte [] sig=x509Cert.getSignature();//签名值
        System.out.println("签名值："+ Arrays.toString(sig));
        PublicKey pk=x509Cert.getPublicKey();
        byte [] pkenc=pk.getEncoded();
        System.out.println("公钥");
        for (byte b : pkenc) {
            System.out.print(b + ",");
        }
    }



}
