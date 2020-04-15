<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
 <html>
   <head><title>Employees List</title></head>
   <body>
   <h2>Employee Details Table:</h2>
   <table border="1">
    <tr bgcolor="#9acd32">
      <th>Id</th>
      <th>Age</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Role</th>
    </tr>
    <xsl:for-each select="Employees/Employee">
    <tr>
     <td><xsl:value-of select="@id"/></td>
     <td><xsl:value-of select="age"/></td>
     <td><xsl:value-of select="firstname"/></td>
     <td><xsl:value-of select="lastname"/></td>
     <td><xsl:value-of select="role"/></td>
    </tr>
    </xsl:for-each>
   </table>
   </body>
 </html>
</xsl:template>
</xsl:stylesheet>
