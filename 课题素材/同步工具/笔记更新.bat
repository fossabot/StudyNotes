@echo off
echo.
echo  ѧϰ�ʼ�ͬ��:
echo  1. ��ȫ���� (Clone)
echo  2. �������� (Pull)
echo.

set /p n=����ѡ���� (1��2 ���˳�) :
if "%n%"=="" cls&goto :test
if "%n%"=="1" call :1
if "%n%"=="2" call :2
if /i "%n%"=="3" exit
pause
goto :eof

:1
echo ��ȫ���� (Clone)
echo ȷ��������?
echo 1. �뱣֤�˽ű��ļ����������ϵ� ����֮ǰClone��ѧϰ�ļ�Ҳ�����棬������ܵ��½ű����д���
echo 2. ��ȷ����û�ж����ʼ�Ŀ¼�µ�.git�������ļ��С�
echo 3. ��ȷ�����Ƿ��Ѿ���װGit.
pause
git clone https://gitee.com/CurtisCN/StudyNotes.git
echo �������� (Clone) ��ɡ�
pause
exit

:2
echo �������� (Pull) 
echo 1. �뱣֤�˽ű��ļ����������ϵ� ����֮ǰClone��ѧϰ�ļ�Ҳ�����棬������ܵ��½ű����д���
echo 2. ��ȷ����û�ж����ʼ�Ŀ¼�µ�.git�������ļ��С�
echo 3. ��ȷ�����Ƿ��Ѿ���װGit.
echo ȷ��������?
pause
cd StudyNotes
git pull origin main
echo ������ȡ (Pull) ��ɡ�
pause
exit
