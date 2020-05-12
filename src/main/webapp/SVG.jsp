<style>
    rect {
        stroke:#000000; fill: transparent;
    }
    .post {
        stroke-width: 4px;
    }
</style>
<%
    int width = 780;
    int height = 600;
    int outhang = 35;
    int rafterCount = 15;
    int rafterSpace = 55;
    int postCount = 3;
    int distant = (width - 10) / (postCount - 2 +1);
%>
<svg width="1000" height="1000">
    <rect x="100" y="100" height="<%= height %>" width="<%= width %>" />

    <rect x="100" y="<%= 100 + outhang %>" height="10" width="<%= width %>" />
    <rect x="100" y="<%= 100 + height - outhang - 10 %>" height="10" width="<%= width %>" />

    <% for(int i = 0; i < rafterCount; i++) { %>
    <rect x="<%= 100 + rafterSpace * i %>" y="100" height="<%= height %>" width="1000" />
    <% } %>

    <rect class="post" x="200" y="<%= 100 + outhang %>" height="10" width="10" />
    <rect class="post" x="<%= 100 + outhang + distant  %>" y="<%= 100 + outhang %>" height="10" width="10" />
    <rect class="post" x="<%= 100 + width - 30 %>" y="<%= 100 + outhang %>" height="10" width="10" />

    <rect class="post" x="200" y="<%= 100 + height - outhang - 10 %>" height="10" width="10" />
    <rect class="post" x="<%= 100 + outhang + distant  %>" y="<%= 100 + height - outhang - 10 %>" height="10" width="10" />
    <rect class="post" x="<%= 100 + width - 30 %>" y="<%= 100 + height - outhang - 10 %>" height="10" width="10" />
</svg>
<%= distant %>