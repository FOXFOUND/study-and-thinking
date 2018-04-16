.386  
.model flat, stdcall  
option casemap:none  
  
include windows.inc  
include user32.inc  
include kernel32.inc  
includelib user32.lib  
includelib kernel32.lib  
  
.data  
szCaption   db 'Duke56',0  
szText      db 'Hello World!',0  
  
.code  
start:  
    invoke MessageBox,\ ; 调用函数名  
    NULL,\          ; 父窗口句柄  
    offset szText,\     ; 文字  
    offset szCaption,\  ; 标题  
    MB_OK           ; 按钮类型  
  
    invoke ExitProcess, NULL  
end start  
