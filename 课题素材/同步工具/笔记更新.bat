@echo off
echo.
echo  ѧϰ�ʼ�ͬ��:
echo  1. ��ȫ���� (Clone)
echo  2. �������� (Pull)
echo  3. �˳� (Exit)
echo.

set /p n=����ѡ���� (1��2 ���˳�) :
if "%n%"=="" cls&goto :test
if "%n%"=="1" call :1
if "%n%"=="2" call :2
if "%n%"=="3" call :3
pause
goto :eof

:1
echo ��ȫ���� (Clone)
echo ȷ��������?
echo 1. �뱣֤�˽ű��ļ����������ϵ� ����֮ǰClone��ѧϰ�ļ�Ҳ�����棬������ܵ��½ű����д���
echo 2. ��ȷ�����Ƿ��Ѿ���װGit.
git clone https://gitee.com/CurtisCN/StudyNotes.git
pause
exit

:2
echo �������� (Pull) 
echo 1. �뱣֤�˽ű��ļ����������ϵ� ����֮ǰClone��ѧϰ�ļ�Ҳ�����棬������ܵ��½ű����д���
echo 2. ��ȷ�����Ƿ��Ѿ���װGit.
pause
cd StudyNotes
git pull origin main
pause
exit

:3
exit
