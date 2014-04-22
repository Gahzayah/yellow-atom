package org.fjub.data;

import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.GDI32;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.platform.win32.WinDef.HWND; 
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinDef.UINT;
import com.sun.jna.platform.win32.WinUser; 
import com.sun.jna.platform.win32.WinUser.*; 


public class JNAHandler {
    
   public interface User32 extends StdCallLibrary {
      // Load user32 Libary
      User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class);
      //Enumerates all top-level windows on the screen by passing the handle to each window
      boolean EnumWindows(WinUser.WNDENUMPROC lpEnumFunc, Pointer arg);
      // WINAPI Functions
      int GetWindowRect(HWND hWnd,RECT Rect);
      int SetWindowPos(HWND hWnd,HWND hWndInsertAfter,int X,int Y,int cx, int cy,UINT uFlags);     
      int GetForegroundWindow();
      int GetWindowTextA(HWND hWnd, byte[] lpString, int nMaxCount);
      int SetForegroundWindow(HWND hWnd);
      int SetFocus(HWND hWnd);
      boolean ShowWindow(HWND hWnd, int nCmdShow);
     // int GetNextWindow(HWND hWnd,UINT GW_HWND);
     // int GetWindow(HWND hWnd,UINT GW_HWND);
   }
   
   /**
    * Get the Size relative to Windows Desktop
    * @param hWnd
    * @return 
    */
    public RECT getRectangle(HWND hWnd)
    {
        final User32 user32 = User32.INSTANCE;
        RECT r  = new RECT();
        user32.GetWindowRect(hWnd,r);       
        // TODO
        //MapWindowPoints(HWND_DESKTOP, GetParent(hWnd), (LPPOINT) &Rect, 2);      
       return r;
    }
    
    public void setRectangle(HWND hWnd,HWND hWndEffect,int x, int y ,int cx,int cy, UINT uint){
        final User32 user32 = User32.INSTANCE;
        //HWND hWndInsertAfter  - TOPMOST = -1,TOP = 0 ,NOTOPMOST = -2,BOTTOM = 1
        //int X                 - x to left-corner 
        //int Y                 - y to left-corner
        //int cx                - width
        //int cy                - height
        //UINT uFlags           - unique flags

        //UINT u = new UINT(Native.SWP_NOSIZE);
        user32.SetWindowPos(hWnd,hWndEffect,x,y,cx,cy,uint);     
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
            // GET A Lobby Window HWND and spec. PL OMaha Table
            if (wText.contains("Lobby - ") || wText.contains("PL Omaha")){
            System.out.println("Found window with text " + hWnd + ", total " + ++count
                  + " Text: " + wText);
            
              user32.SetForegroundWindow(hWnd);
              user32.ShowWindow(hWnd,1);                      

              System.out.println("hWnd - x to left-corner: " + getRectangle(hWnd).left);
              System.out.println("hWnd - y to top-corner: " + getRectangle(hWnd).top);
              System.out.println("hWnd - x to right-corner: " + getRectangle(hWnd).right);
              System.out.println("hWnd - y to bottom-corner: " + getRectangle(hWnd).bottom);
              
              UINT u = new UINT();
              // Doesnt Work yet
              setRectangle(hWnd,hWnd,0,0,getRectangle(hWnd).right,getRectangle(hWnd).bottom,u);             
              
            }
            
            return true;
         }
         
         
      }, null);
      
      
   }
   
     
}