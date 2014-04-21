package org.fjub.data;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.platform.win32.WinDef.HWND; 
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinUser; 
import com.sun.jna.platform.win32.WinUser.*; 


public class NewClass {
    
   public interface User32 extends StdCallLibrary {
      // Load user32 Libary
      User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);
      //Enumerates all top-level windows on the screen by passing the handle to each window
      boolean EnumWindows(WinUser.WNDENUMPROC lpEnumFunc, Pointer arg);

      RECT GetWindowRect(HWND hWnd,RECT Rect);
      HWND GetForegroundWindow();
      int GetWindowTextA(HWND hWnd, byte[] lpString, int nMaxCount);
      int SetForegroundWindow(HWND hWnd);
      int SetFocus(HWND hWnd);
      boolean ShowWindow(HWND hWnd, int nCmdShow);
     // int GetNextWindow(HWND hWnd,UINT GW_HWND);
     // int GetWindow(HWND hWnd,UINT GW_HWND);
   }
    RECT getRectangle(HWND hWnd)
    {
        final User32 user32 = User32.INSTANCE;
        RECT rect = null;
        user32.GetWindowRect(hWnd, null);
        //MapWindowPoints(HWND_DESKTOP, GetParent(hWnd), (LPPOINT) &Rect, 2);
       
       return rect;
    }
   public void listOpenWindows() {
      final User32 user32 = User32.INSTANCE;
      
      user32.EnumWindows(new WNDENUMPROC() {
         int count = 0;
       
         @Override
         public boolean callback(HWND hWnd, Pointer arg1) {
            byte[] windowText = new byte[512];
            user32.GetWindowTextA(hWnd, windowText, 512);
           
            String wText = Native.toString(windowText);
            

            // get rid of this if block if you want all windows regardless of whether
            // or not they have text
            if (wText.isEmpty()) {
               return true;
            }
            if (wText.contains("Lobby - ") || wText.contains("PL Omaha")){
            System.out.println("Found window with text " + hWnd + ", total " + ++count
                  + " Text: " + wText);
            
              System.out.println("Foreground Window: " +  user32.GetForegroundWindow());
              System.out.println("Set Foreground(hWnd): " + hWnd);
              user32.SetForegroundWindow(hWnd);
              user32.ShowWindow(hWnd,1);
              
            }
            
            return true;
         }
         
         
      }, null);
      
      
   }
   
     
}