import type { Metadata } from "next";
import { Roboto } from "next/font/google";
import "./globals.css";
import AppProvider from "@/providers";

const roboto = Roboto({ subsets: ["latin"], weight: "400" });

export const metadata: Metadata = {
  title: "Book Store",
  description: "An online book store",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body className={roboto.className}>
        <AppProvider>{children}</AppProvider>
      </body>
    </html>
  );
}
