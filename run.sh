#!/bin/bash

# GoReserve - Simple Run Script

echo "🚀 Starting GoReserve..."
echo ""

# Compile and run
javac -d . src/com/reservation/*.java 2>&1 | grep -v "Note:" || true

if [ $? -eq 0 ]; then
    java com.reservation.TicketReservationApp
else
    echo "❌ Compilation failed!"
    exit 1
fi
