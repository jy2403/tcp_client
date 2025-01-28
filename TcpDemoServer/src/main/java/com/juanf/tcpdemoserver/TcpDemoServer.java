/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.juanf.tcpdemoserver;

import networklayer.TCPserver;

/**
 *
 * @author juanf
 */
public class TcpDemoServer {

    public static void main(String[] args) {
        TCPserver server = new TCPserver(9090);
        server.start();
    }
}
