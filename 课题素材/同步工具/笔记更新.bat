@echo off
echo.
echo  学习笔记同步:
echo  1. 完全下载 (Clone)
echo  2. 增量更新 (Pull)
echo.

set /p n=输入选择项 (1，2 或退出) :
if "%n%"=="" cls&goto :test
if "%n%"=="1" call :1
if "%n%"=="2" call :2
if /i "%n%"=="3" exit
pause
goto :eof

:1
echo 完全下载 (Clone)
echo 确定继续吗?
echo 1. 请保证此脚本文件是在桌面上的 且你之前Clone的学习文件也在桌面，否则可能导致脚本运行错误。
echo 2. 请确认你没有动过笔记目录下的.git的隐藏文件夹。
echo 3. 请确认你是否已经安装Git.
pause
git clone https://gitee.com/CurtisCN/StudyNotes.git
echo 代码下载 (Clone) 完成。
pause
exit

:2
echo 增量更新 (Pull) 
echo 1. 请保证此脚本文件是在桌面上的 且你之前Clone的学习文件也在桌面，否则可能导致脚本运行错误。
echo 2. 请确认你没有动过笔记目录下的.git的隐藏文件夹。
echo 3. 请确认你是否已经安装Git.
echo 确定继续吗?
pause
cd StudyNotes
git pull origin main
echo 代码拉取 (Pull) 完成。
pause
exit
