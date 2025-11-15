@echo off
REM GoReserve - Simple Run Script

echo Starting GoReserve...
echo.

REM Compile and run
javac -d . src\com\reservation\*.java 2>nul

if %errorlevel% equ 0 (
    java com.reservation.TicketReservationApp
) else (
    echo Compilation failed!
    exit /b 1
)
